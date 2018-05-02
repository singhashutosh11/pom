cls
set projectLocation=C:\Users\aramachandra\git\CFSA
cd %projectLocation%
set classpath=%projectLocation%\bin;C:\Users\aramachandra\.m2\repository\*
echo %classpath%
cmd.exe /k mvn clean test
pause