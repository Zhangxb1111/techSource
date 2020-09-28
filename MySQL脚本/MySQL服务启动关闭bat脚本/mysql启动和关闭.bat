
@echo off
%1 mshta vbscript:CreateObject("Shell.Application").ShellExecute("cmd.exe","/c %~s0 ::","","runas",1)(window.close)&&exit
cd /d "%~dp0"

:sc_main
echo 1.启动请按：1
echo 2.关闭请按：2
echo 3.退出请按：0
set "select="
set/p select= 输入数字，按回车继续 :
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
