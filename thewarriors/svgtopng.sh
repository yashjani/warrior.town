 #!/bin/bash
 cd $1
 for f in *.svg; 
 do 
    echo "Processing $f file.."; 
    name=$(echo "$f" | cut -f 1 -d '.')
    out=${name}.png
    echo "basename $out file..";
    inkscape $f -o $out
   # rm $f
    echo "Processing $f file completed.."; 
 done