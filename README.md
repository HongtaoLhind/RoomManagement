# Übungsprojekt "Room Management"

Dies ist das Basisprojekt für die "Room Management"-Übung. Ziel dieser Übung ist der Einsatz der in den vorherigen
Schulungen vermittelten Inhalte zu den Themen Architektur und Entwicklung mit dem Spring-Framework. Dabei werden
insbesondere die folgenden Technologien eingesetzt:

* Spring Framework
  * Spring Boot
  * Spring REST
  * Spring Data JPA
* JPA (Hibernate)
* Unit-Tests mit JUnit, Mockito und AssertJ

## Funktionale Anforderungen

Die finale Applikation soll eine klassische Stammdatenbearbeitung (CRUD) inkl. einiger Suchoperationen über eine
REST-API anbieten.

---

**Wichtig**: Die Implementierung der Entität `Meeting` ist ein optionaler Bestandteil.

---

Das Domain-Model besteht aus drei Entitäten:
* `Building`: Repräsentiert ein Gebäude
* `Room`: Repräsentiert einen Raum. Dieser ist einem Gebäude zugeordnet.
* `Meeting` (optional): Repräsentiert ein Meeting/Vortrag/Veranstaltung und ist einem Raum zugeordnet.

Die erforderlichen Attribute der Entitäten werden nachfolgend aufgelistet.

### Entität Building

Ein Gebäude hat die folgenden natürlichen Attribute:
* Gebäudenummer
* Optionale Beschreibung
* Ein Flag, ob ein öffentlicher Zugang möglich ist


| Attribut        | Eigenschaften               |
| --------------- | --------------------------- |
| Building Number | `String`, required, unique  |
| Description     | `String`, optional          |
| Public Access   | `Boolean`, required         |

### Entität Room

Ein Raum hat die folgenden natürlichen Attribute:
* Gebäude
* Raumnummer
* Anzahl Sitzplätze
* Ein Flag, ob ein Beamer vorhanden ist

| Attribut          | Eigenschaften                            |
| ----------------- | ---------------------------------------- |
| Building          | `Building`, required                     |
| Room number       | `String`, required                       |
| Seats             | `Integer`, required, zwischen 1 und 9999 |
| Projector present | `Boolean`, required                      |

Zusätzlich muss die Anwendung sicherstellen, dass die Kombination aus *Gebäude* und *Raumnummer* eindeutig ist.

### Entität Meeting (optional)

Ein Meeting hat die folgenden natürlichen Attribute:
* Raum
* Betreff  
* Start- und Endzeit

| Attribut | Eigenschaften       |
| ---------| ------------------- |
| Room     | `Room`, required    |
| Topic    | `String`, required  |
| Start    | `Instant`, required |
| End      | `Instant`, required |

### Geforderte Funktionen

Die Anwendung soll die folgenden Funktionen über eine REST-API anbieten:

* Gebäude
  * Alle Gebäude auflisten
  * Ein Gebäude anlegen, ändern und löschen
  * Ein Gebäude über die Gebäudenummer suchen
  * Alle Gebäude mit öffentlichem Zugang suchen
* Raum
  * Alle Räume auflisten
  * Einen Raum anlegen, ändern und löschen
  * Einen Raum über Gebäudenummer und Raumnummer suchen
  * Alle Räume eines Gebäudes suchen
  * Alle Räume mit öffentlichem Zugang suchen
* Meeting (**optional**)
  * Alle Meetings auflisten
  * Ein Meeting anlegen, ändern und löschen
  * Alle Meetings in einem bestimmten Zeitraum (von, bis) suchen
  * Alle Meetings in einem Gebäude in einem bestimmten Zeitraum (von, bis) suchen
  * Alle Meetings in einem Raum in einem bestimmten Zeitraum (von, bis) suchen
  
## Technische Anforderungen

Zusätzlich zu den funktionalen Anforderungen sind die nachfolgend aufgelisteten technischen Anforderungen 
zu erfüllen.

### REST API

Die Anwendung muss eine den üblichen REST-Standards folgende REST-API anbieten.

Fehlerbehandlung erfolgt durch den Einsatz von HTTP-Statuscodes.

### Schichtenarchitektur

Die Anwendung muss eine Drei-Schicht-Architektur implementieren:

```mermaid
graph TD;
  A[REST Controller] --> B[Service];
  B --> C[Repository];
```

Die einzelnen Schichten sollen dabei auf Basis der folgenden Technologien entwickelt werden:

* REST Controller
  * Spring REST Controller (Spring MVC)
* Service
  * Standard Spring Framework
* Repository
  * Spring Data JPA
  * Hibernate
* Database
  * H2

Es ist dabei erlaubt, ergänzende Technologien einzusetzen, solange diese nicht die oben aufgeführten Technologien
ersetzen oder die Drei-Schicht-Architektur umgehen.
  
### Transaktionsbehandlung

Eine saubere Transaktionsbehandlung ist erforderlich. Wichtig ist dabei insbesondere, die Transaktionsklammer in der
richtigen Schicht zu setzen (*Unit of Work*).

### Testing

Unit-Tests werden idealerweise in jeder Schicht implementiert. 

Im Rahmen dieser Übung ist allerdings die Implementierung der Unit Tests nur für die *Controller* und die
*Services* verpflichtend. Eine vollständige Testabdeckung aller Methoden ist für diese Übung nicht erforderlich.

Optional können Unit Tests natürlich auch für die *Repositories* gebaut werden.

## Testen der Anwendung

Ein Testen der Anwendung ist jederzeit lokal in der IDE möglich. Hierzu einfach die Spring-Boot-Anwendung starten.
Die IntelliJ generiert hierfür automatisch eine Run Configuration. Alternativ kann auch auf das *Play*-Symbol in
der Main-Klasse `de.dlh.lhind.exercise.roommgmt.RoommmgmtApplication` geklickt werden.

Das Testen der REST-API erfolgt am besten unter Einsatz von *HTTP Scratch-Files*. Diese können direkt in der IntelliJ
angelegt werden.

**Viel Erfolg und viel Spaß!**
