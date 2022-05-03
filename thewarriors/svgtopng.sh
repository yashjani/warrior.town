 #!/bin/bash
 cd $1
 cd svg
 for f in *.svg; 
 do 
    echo "Processing $f file.."; 
    name=$(echo "$f" | cut -f 1 -d '.')
    outJpg=${name}.jpg
    outPng=${name}.png
    echo "basename $out file..";
    inkscape $f -o $outPng
    convert -trim $outPng $outPng
    convert -quality 85 $outPng $outJpg
    echo "Processing $f file completed.."; 
 done
 
 
 for f in *.png; 
 do 
    echo "Copying $f file.."; 
    name=$(echo "$f" | cut -f 1 -d '.')
    echo $name
    opensea="${name#*_}.png"
    echo $opensea
    cp $f "/Users/Rang/Documents/NFT/warrior.town/warrior.town/thewarriors/sumo/$2/output/opensea/$opensea"
    rm $f
    echo "Processing $f file completed.."; 
 done
 
 for f in *.jpg; 
 do 
    echo "Copying $f file.."; 
    name=$(echo "$f" | cut -f 1 -d '.')
    echo $name
    aws="${name%%_*}.jpg"
    echo $aws
    cp $f "/Users/Rang/Documents/NFT/warrior.town/warrior.town/thewarriors/sumo/$2/output/aws/$aws"
    rm $f
    echo "Processing $f file completed.."; 
 done