@echo off
 
echo Verificando se as dependências já foram instaladas...
if exist "node_modules" (
    echo Dependências já instaladas. Pulando npm install...
) else (
    echo Instalando as dependências com npm install...
    npm install || (
        echo Erro ao executar npm install.
        pause
        exit /b
    )
)

echo Iniciando o servidor com npm run dev...
npm run dev || (
    echo Erro ao executar npm run dev.
    pause
    exit /b
)

pause
