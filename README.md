# TDD_Rover


Testgetriebene Roverentwicklung

Commit von Roten Test erstellen
Test Grün machen
Neuen Commit


Entwickelt eine API, die einen Rover auf dem Mars bewegt. Die Landschaft soll als Grid darge-stellt werden. Der Rover erhält den anfänglichen Startpunkt als Koordinate(x,y) und die Rich-tung (N, S, O, W), in die er zeigt.

Der Rover empfängt eine Reihe von Befehlen:

- vorwärts: f

- rückwärts: b

- nach links drehen: l

- nach rechts drehen: r

- nach oben fahren: u

- nach unten fahren: d

Bei der Steuerung des Rovers ist der Umbruch von einer Kante oder dem Gitter zu einer an-deren zu berücksichtigen (Planeten sind schließlich Kugeln).

Beispiel: Der Rover befindet sich auf einem 100x100-Raster an Position (0, 0) und ist nach SÜDEN ausgerichtet. Dem Rover werden die Befehle „fflff“ und gegeben sollte daher bei (2,2) enden.

Implementiert eine Hinderniserkennung vor jedem Zug auf ein neues Feld. Wenn eine be-stimmte Befehlsfolge auf ein Hindernis trifft, fährt der Rover zum letztmöglichen Punkt und meldet das Hindernis. Es gibt mindestens die Hindernisse Abgrund und Berg. Eine Steigung von unter 15% nach oben und unten bewältigt der Rover.

Die Simulation soll jederzeit abgebrochen und zu einem späteren Zeitpunkt fortgesetzt wer-den können. Der Spielstand muss also gespeichert und wieder geladen werden können. Die Datenbank ist frei wählbar, d.h. es kann eine beliebige relationale Datenbank oder eine NoSQL-Datenbank gewählt werden. Das Programm sollte aber out of the box laufen. Lasst die Datenbank daher in einem Dockercontainer laufen oder verwendet eine über das Netz er-reichbare Datenbank.

Die Anwendung ist testgetrieben mit Java, Junit und Mockito zu entwickeln. Euer Projekt ist wie folgt zu versionieren: Nach jedem roten Test ist ein Commit zu erstellen: Schreibt also einen roten Test, committet. Danach führt ihr die Implementierung, das Refactoring durch und schreibt den nächsten roten Test. Nun ist wiederum zu committen. Der Commit soll je-weils mit dem Klassennamen, für die der aktuelle Test geschrieben wird, sowie dem Namen der Testmethode bezeichnet werden.