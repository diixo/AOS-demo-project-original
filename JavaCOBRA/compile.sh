echo "Compiling IDL into Java Code"

echo "idlj -fall  Hello.idl"

idlj -fall  Hello.idl

echo "Compiling Java files, including stubs and skeletons"

echo "javac *.java HelloApp/*.java"

javac *.java HelloApp/*.java


