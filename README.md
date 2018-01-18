## Checkout app

To allow for frequent changes in pricing, this programm uses data from the `pricing.xml` in the project root. Sample file is supplied.

### Usage

- Install SBT if not already installed: `$ brew install sbt` 

- To run tests: `$ sbt test`
- To run the app: `$ sbt run`

To add an item to checkout enter A, B, C, or D when prompted, or Q to exit (case insensitive). 

### TODO

- Implement multibuy offer handling
- Improve input validation and error handling