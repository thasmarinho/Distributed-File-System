@echo off
cls
@echo.
@echo    ***********************************************
@echo    ***                                         ***
@echo    ***     INICIANDO O SISTEMA DE ARQUIVOS     ***
@echo    ***                                         ***
@echo    ***********************************************
@echo.
pause
cd C:\Users\Bruno Augusto\Desktop\meuT3\src\trab3
javac *.java
cd..
pause
echo Arquivos .java compilados com sucesso!
Start java trab3.NoArmazenamento
pause
echo No1 criado
Start java trab3.NoArmazenamento
pause
echo No2 criado
Start java trab3.NoArmazenamento
pause
echo No3 criado
Start java trab3.NoArmazenamento
pause
echo No4 criado
Start java trab3.NoArmazenamento
pause
echo No5 criado
Start java trab3.NoArmazenamento
pause
echo No6 criado
Start java trab3.BalanceadorDeCargas
pause
echo Balancer criado
Start java trab3.ProxyReal
pause
echo Proxy1 criado
Start java trab3.ProxyReal
pause
echo Proxy2 criado
Start java trab3.ProxyReal
pause
echo Proxy3 criado
Start java trab3.Client
pause
echo client criado
pause
@echo.
@echo    ***********************************************
@echo    ***                                         ***
@echo    ***         Sistema pronto para uso         ***
@echo    ***                                         ***
@echo    ***********************************************
@echo.
pause
