package com.thewarriors.us.service;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Hashtable;

import org.jfree.graphics2d.svg.SVGGraphics2D;
import org.jfree.graphics2d.svg.ViewBox;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

@Service
public class QRCodeService {
	
	@Autowired
	ImageTransparency imageTransparency;
	
	public String getQRCodeSvg(String backGroundColor, String targetUrl, int width, int height, boolean withViewBox) {
		SVGGraphics2D g2 = new SVGGraphics2D(width, height);
		BufferedImage qrCodeImage = getQRCode(backGroundColor, targetUrl, width, height);
		g2.drawImage(qrCodeImage, 60, 50, 150, 150, null);

		ViewBox viewBox = null;
		if (withViewBox) {
			viewBox = new ViewBox(0, 0, 1800, 1800);
		}
		return g2.getSVGElement(null, false, viewBox, null, null);
	}

	public BufferedImage getQRCode(String backGroundColor, String targetUrl, int width, int height) {
		try {
			Hashtable<EncodeHintType, Object> hintMap = new Hashtable<>();

			hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
			QRCodeWriter qrCodeWriter = new QRCodeWriter();
			BitMatrix byteMatrix = qrCodeWriter.encode(targetUrl, BarcodeFormat.QR_CODE, width, height, hintMap);
			int CrunchifyWidth = byteMatrix.getWidth();

			BufferedImage image = new BufferedImage(CrunchifyWidth, CrunchifyWidth, BufferedImage.TYPE_INT_RGB);
			image.createGraphics();

		    Graphics2D graphics = (Graphics2D) image.getGraphics();
			String[] backGround = backGroundColor.split(",");
			Color color = new Color(255,255,255);
			graphics.setColor(color);
			graphics.fillRect(0, 0, CrunchifyWidth, CrunchifyWidth);
			Color color1 = new Color(255- Integer.valueOf(backGround[0]), 255 - Integer.valueOf(backGround[1]),
					255 - Integer.valueOf(backGround[2]));
			graphics.setColor(color1);

			for (int i = 0; i < CrunchifyWidth; i++) {
				for (int j = 0; j < CrunchifyWidth; j++) {
					if (byteMatrix.get(i, j)) {
						graphics.fillRect(i, j, 1, 1);
					}
				}
			}
			return imageTransparency.removeWhiteBg(image);
		} catch (WriterException e) {
			e.printStackTrace();
			throw new RuntimeException("Error getting QR Code");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

}
