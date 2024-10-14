# Repositorio para 1er Parcial Mutantes Programación 3 - Cosentino Joaquin

# Instrucciones para ejecutar la API:

- URL de la API (hosteada en Render): https://adnmutante.onrender.com/mutant/

- Con Postman:
1. Abrir Postman
2. Clickear el botón '+', ubicado arriba a la izquierda
3. Nos vamos a dirigir a la sección de 'Body', seleccionamos 'raw'
4. Nos aseguramos que el tipo de archivo a enviar sea 'JSON', seleccionandolo de la lista al lado del botón 'GraphQL'
5. En el interior del Body, colocamos lo siguiente:
   - Ejemplo humano: {
   "dna": ["ATTTGA", "CAGTGC", "TTATTT", "AGAAGG", "GCGTCA", "TCACTG"]
   }
   
   - Ejemplo mutante: {
     "dna": ["ATTTGA", "TAGTGC", "TTATTT", "TGAAGG", "TCGTCA", "TCACTG"]
     }

(recordemos que el ADN se considerará mutante SOLO si se encuentra más de 1 combinación)

6. A la izquierda de la sección URL, nos aseguramos que el método a enviar sea 'POST' en el caso de querer verificar ADN mutante; o 'GET' en el caso de querer visualizar las estadisticas de la base de datos
    - En el caso de 'POST', colocamos la siguiente url "https://adnmutante.onrender.com/mutant/"
    - En el caso de 'GET', colocamos la siguiente url "https://adnmutante.onrender.com/stats/"

7. Luego, presionamos el botón 'Send', ubicado en el márgen superior derecho. Esto enviará el archivo en formato JSON con el contenido del ADN, el programa analizará lo enviado, y retornará una respuesta en formato JSON.

- Con 'cURL':
1. Abrimos bash en nuestro computador
2. Para realizar un POST, colocamos lo siguiente (se recomienda copiar y pegar):
   - curl -X POST https://adnmutante.onrender/mutant/ \
   -H "Content-Type: application/json" \
   -d '{
   "dna": ["ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"]
   }'
   (puedes modificar el ADN como te guste y hacer pruebas)
3. Para realizar un GET y obtener las estadisticas, colocamos lo siguiente:
   - curl -X GET https://adnmutante.onrender/stats/

 