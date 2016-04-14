# DependenciesParser
Parsing Package Dependencies Project

#To Run
Save your packages.txt file under src/sample/(Your desired txt file) - the file you want to parse

for windows users;

go to src/sample/ and perform:

```
javac Main.java
```

then go back using cd.. and on src/ perform:
```
java sample.Main packages.txt (your desired packages to search)
```
for example:
```
java sample.Main packages.txt swingui awtui unknown
```


**The code has been tested and compiled on Windows 64-bit OS**


sample input:
```
java sample.Main packages.txt swingui awtui unknownme gui
```
sample output:
```
swingui -> extensions framework runner
awtui -> framework runner
unknownme ->
gui -> awtui extensions framework runner swingui
```



