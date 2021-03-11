#Université de CAEN 2020/2021
#CC GENIE LOGICIEL
#21701042 HUET Bryan, 21805281 ACUNA Mithian, 21802829 BOURNONVILLE Aurelien, 21807118 TANNI Matteo
--------------------------------------------------------------------------------


Pour compiler et executer l'application deux librairies externe à java sont nécessaire :
javaFX et json-simple.

javaFX : https://openjfx.io/
json-simple : est directement fourni avec l'application disponible dans dist/jar


*------------------------------*
|    COMPILATION & EXECUTION   |
*------------------------------*

> par script.sh
en se plaçant dans le répertoire livraison, il suffit d'executer le script shell de la manière suivante :
 $ ./launch.sh

> par script ant
en se plaçant dans le répertoire livraison, il suffit d'entrer la commande :
 $ ant
il est possible de clean le projet avec la commande :
 $ ant clean

> par jar
Une version jar de l'application est disponible depuis le dossier dist/jar avec pour nom Pokano.jar. Attention,
cependant il est possible que ce jar ne dispose pas du code produit le plus récent. De plus, lancer l'application de cette
manière rend inaccessible la lecture des fichiers de sauvegarde de partie et de score.