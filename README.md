# PgAr2021_GliAxolotl_TamaGolem

Il metodo per "pulire" lo schermo funziona stampando tanti a capo, abbiamo scelto questa via
dopo aver fatto delle ricerche e visto la difficoltà di implementare un metodo che
compiesse quest'azione sul terminale (ci sono problemi con i sistemi operativi delle macchine).
Se per i fini della correzione del codice, preferite non avere lo schermo "pulito" ogni volta
potete evitrlo, andando a commentare nella classe GestioneSchermo l'interno del metodo clearScreen.

Durante il combattimento ci saranno dei rallentamenti, sono intenzionali, così che uno possa leggere il testo
che descrive gli avvenimenti nello scontro. Anche in quessto caso sì può togliere andando a commentare il
contenuto del metodo pausa3sec in GestioneSchermo.

Nella stampa finale dell'equilibrio del mondo viene stampata una tabella di numeri e nomi degli elementi,
i numeri, che risultano all'incrocio di due elementi, possono essere positivi o negativi. Se il numero è positivo
significa che sarà l'elemento sulla riga orizzontale a subire il danno (indicato dal valore assoluto nella casella), in caso invece sia negativo
sarà l'elemento della colonna verticale il ricevente del danno (sempre il valore assoluto nella casella).
