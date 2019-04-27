@echo off
SET mypath=%~dp0
mode con cols=180 lines=30
cd %mypath:~0,-1%/BattleShipGameFiles
python BattleShip.py
pause