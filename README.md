# calctext

A text based calculator

## Usage

Run the program with leiningen giving it the location to the file that contains the operations:
```sh
lein run filename
```

For example, if you give it a file with the following:
```
ADD  5
MULT 5
DIV  5
```

The program should print:
```
5
```

The following operations are supported:
- ADD x for addition
- SUB x for substraction
- MULT x for multiplication
- DIV x for division
- SQR for square

## Tests

Run the tests with leiningen:
```
lein test
```

## License

Copyright © 2018
