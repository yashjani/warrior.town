 #!/bin/bash
 cd $1
 for f in *.png; 
 do 
    echo "Copying $f file.."; 
    name=$(echo "$f" | cut -f 1 -d '.')
    echo $name
    aws="${name%%_*}.jpg"
    convert -quality 85 $f $aws
    echo $aws
    rm $f
    echo "Processing $f file completed.."; 
 done
