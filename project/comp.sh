#/////////////////////////////////////
#//    DEVELOPPEUR : PCTRONIQUE     //
#/////////////////////////////////////

#!/bin/sh

cd ${0%/*}

rm -rf build
mkdir build
cd build
cmake ../
make
unzip ROOT.jar -d ROOT/ > /tmp/zip.log
cd ROOT/
mv META-INF/MANIFEST.MF ../tmp/web/META-INF/
rm -rf META-INF/
mkdir -p ../tmp/web/WEB-INF/classes/
cp -r * ../tmp/web/WEB-INF/classes/
cd ../tmp/web/
zip -r ROOT.war * > /tmp/zip.log
cp ROOT.war ../../../.webapps/
cd ../../../
rm -rf build
