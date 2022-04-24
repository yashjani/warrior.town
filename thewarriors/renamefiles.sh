 #!/bin/bash
 cd $1
 cd aws
 for f in *.png; 
 do 
   echo "Processing $f file..";  
   name=$(echo "$f" | cut -f 1 -d '.')
   echo "${name##*_}"
   echo "${name#*_}.png"
   #mv $f "${name%%_*}.png"
 done
