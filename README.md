 *Non ho mai scritto un file README quindi non so bene come si faccia, vado a tentativi*
 
- Ho deciso di creare una classe astratta CatalogueElement da cui discendano Book e Magazine;
- Essendo le differenze tra le due classi concrete ridotte, ho pensato che SingleTable sia perfetta per rappresentarne l'ereditarietà:
- le caselle NULL saranno poche e non ci saranno grossi problemi di prestazioni nell'effettuare i Join tra le tabelle per accedere ai Loan
- (non sapevo come rappresentare le classi ereditate nel grafico visto che l'id sta nella classe astratta avendo scelto la SingleTable; temo non sia nemmeno corretto inserirle nello schema visto che non hanno relazioni con Loan e User, ma corro il rischio a scanso di equivoci).
- Per quanto riguarda i tipi di relazioni, nella traccia era chiaramente specificato che con un prestito si potesse ottenere un solo elemento: la relazione tra Loan e CatalogueElement è quindi secondo me una ManyToOne (ogni prestito contiene un solo elemento ma uno stesso elemento può essere oggetto di più prestiti).
- In maniera del tutto analoga, Loan e User sono legati da una relazione ManyToOne: un prestito è attribuibile a un solo utente ma lo stesso utente può richiedere più prestiti.