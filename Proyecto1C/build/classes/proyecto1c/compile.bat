java -jar ../../lib/java-cup-11b.jar -parser Parser Parser.cup
java -jar ../../lib/jflex-full-1.9.1.jar Lexer.flex
java -jar ../../lib/java-cup-11b.jar -parser Parser Parser_err_all.cup
java -jar ../../lib/java-cup-11b.jar -parser Parser Parser_err_panic.cup
java -jar ../../lib/java-cup-11b.jar -parser Parser Parser_err_phrase.cup
java -jar ../../lib/java-cup-11b.jar -parser Parser Parser_err_prod.cup