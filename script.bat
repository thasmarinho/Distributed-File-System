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
cd C:\Users\Thais\Documents\GitHub\Distributed-File-System
javac *.java
pause
echo Arquivos .java compilados com sucesso!
java NoDeArmazenamento.java
echo No1 criado
java NoDeArmazenamento.java
echo No2 criado
java NoDeArmazenamento.java
echo No3 criado
java NoDeArmazenamento.java
echo No4 criado
java NoDeArmazenamento.java
echo No5 criado
java NoDeArmazenamento.java
echo No6 criado
pause
java ProxyReal.java
echo Proxy1 criado
pause
java Balanceador.java
echo Balanceador criado
pause
java Cliente.java
echo Cliente criado
pause
@echo.
@echo    ***********************************************
@echo    ***                                         ***
@echo    ***         Sistema pronto para uso         ***
@echo    ***                                         ***
@echo    ***********************************************
@echo.
echo Entre a operacao que deseja realizar: Criar[1] Ler[2] arquivo