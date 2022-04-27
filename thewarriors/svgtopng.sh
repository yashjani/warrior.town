 #!/bin/bash
 cd $1
 cd svg
 for f in *.svg; 
 do 
    echo "Processing $f file.."; 
    name=$(echo "$f" | cut -f 1 -d '.')
    out=${name}.png
    echo "basename $out file..";
    inkscape $f -o $out
    convert -trim $out $out
    echo "Processing $f file completed.."; 
 done
 
 
 for f in *.png; 
 do 
    echo "Copying $f file.."; 
    name=$(echo "$f" | cut -f 1 -d '.')
    echo $name
    aws="${name%%_*}.png"
    opensea="${name#*_}.png"
    echo $aws
    cp $f "/Users/Rang/Documents/NFT/warrior.town/warrior.town/thewarriors/sumo/$2/output/aws/$aws"
    cp $f "/Users/Rang/Documents/NFT/warrior.town/warrior.town/thewarriors/sumo/$2/output/opensea/$opensea"
    rm $f
    echo "Processing $f file completed.."; 
 done
 