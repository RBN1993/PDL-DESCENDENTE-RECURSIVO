# PDL-DESCENDENTE-RECURSIVO
Se plantea realizar el diseño e implementación de un procesador de lenguajes que realiza un análisis léxico, sintáctico y semántico 
del lenguaje JavaScript-PL, incluyendo la tabla de símbolos local y global. Para el desarrollo de este analizador nos apoyamos de la 
herramienta JavaCC que es un generador de analizadores sintácticos descendente. El código fuente está escrito en el lenguaje de Java,
la entrada de este programa es un código fuente JavaScript(.js) y si el análisis es correcto genera 3 ficheros(tokens.txt, parser.txt 
y TablaDeSimbolos.txt) en el mismo directorio del código. Si este análisis no es correcto se muestran los errores léxico y sintácticos
en la consola, y los errores semánticos en el fichero log.txt. Para comprobar que el análisis es correcto construimos el árbol sintáctico 
con el parser, para esto nos apoyamos de la herramienta proporcionada por la asignatura(VASt). Para la compilación de nuestra práctica 
se debe añadir lo siguiente:  
• Para que funcione JavaCC se debe incluir al PATH la siguiente ruta del disco PROYECTO- PDL/javacc/bin  
• Desde el cmd se ejecuta lo siguiente: java LexicoSintactico < fichero.js > log.txt, y esto genera todos los ficheros(tokens.txt, 
TablaDeSimbolos.txt y parser.tx)
