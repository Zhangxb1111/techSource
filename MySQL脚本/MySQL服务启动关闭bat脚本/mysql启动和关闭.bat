
@echo off
%1 mshta vbscript:CreateObject("Shell.Application").ShellExecute("cmd.exe","/c %~s0 ::","","runas",1)(window.close)&&exit
cd /d "%~dp0"

:sc_main
echo 1.�����밴��1
echo 2.�ر��밴��2
echo 3.�˳��밴��0
set "select="
set/p select= �������֣����س����� :
if "%select%"=="1" (goto sc_start) 
if "%select%"=="2" (goto sc_stop) 
if "%select%"=="0" (goto sc_exit) 

:sc_exit
exit
goto :eof

:sc_start
net start mysql
PAUSE >nul
Goto sc_mains

:sc_stop
net stop mysql
PAUSE >nul
Goto sc_main

echo 
echo. & pause
