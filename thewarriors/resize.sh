 cd $1
 for f in *.jpg; 
 do 
    echo "Processing $f file.."; 
    name=$(echo "$f" | cut -f 1 -d '.')
    echo "basename $f file..";
    convert -resize 800x800 $f $f
    echo "Processing $f file completed.."; 
 done