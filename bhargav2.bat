D:
set ProjectPath=D:\Users\bhargav\workspace32\Seleniumexplore\
echo %ProjectPath%
cd %ProjectPath%
set classpath=%ProjectPath%\bin;%ProjectPath%\lib\*;
echo %classpath%
java org.testng.TestNG %ProjectPath%\TetNgExample1.xml
Pause