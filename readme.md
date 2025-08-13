# ByteEncoder

ByteEncoder is a simple Java utility for encoding binary, octal, hexadecimal and base32 strings into byte arrays. It provides command-line functionality and static methods for programmatic use.

## Features
- Encode binary strings to byte arrays
- Encode octal strings to byte arrays
- Encode hexadecimal strings to byte arrays
- Encode base32 strings to byte arrays
- Handles invalid input gracefully

## Usage

### Command Line
Run the program with the following arguments:

```
java -cp target/classes org.threadmatrix.ByteEncoder <format> <input>
```
- `<format>`: `binary`,`octal`, `hexadecimal`, or `base32`
- `<input>`: The string to encode

Example:

For binary encoding:
```
java -cp target/classes org.threadmatrix.ByteEncoder binary 101010
```
This will output the byte array representation of the binary string `101010`.

For octal encoding:
```
java -cp target/classes org.threadmatrix.ByteEncoder octal 1234567
```
For hexadecimal encoding:
```
java -cp target/classes org.threadmatrix.ByteEncoder hexadecimal 1A2B3C
```
For base32 encoding:
```
java -cp target/classes org.threadmatrix.ByteEncoder base32 JBSWY3DP
```

### Programmatic
You can use the static methods directly:

```java
byte[] binaryBytes = ByteEncoder.getBinaryToByteEncodedArray("101010");
byte[] octalBytes = ByteEncoder.getOctalToByteEncodedArray("1234567");
byte[] hexBytes = ByteEncoder.getHexadecimalToByteEncodedArray("1A2B3C");
byte[] base32Bytes = ByteEncoder.getBase32ToByteEncodedArray("JBSWY3DP");
```

## Requirements
- Java 8 or higher
- Maven

## Example Input:
``

        /*
        String longOctalString = "227711474231113516702134342400414143206126/*40367166054" +
                "55350700124251451433665154621070427111157201067171276700627170465777043" +
                "334607301704736021762632546715076300657713354152655466766041402716542311" +
                "111131505761476052650004524216161770521652245433114475436547416173670422" +
                "136456436313334657533062163564254163664432653550166600433332675642447003" +
                "252221104064117622317044717471111";

        byte[] binaryToDecimal = getBinaryToByteEncodedArray("0100000101111010101010000001111010111111101010101001");
        byte[] octalToDecimal1 = getOctalToByteEncodedArray("31646541");
        byte[] octalToDecimal2 = getOctalToByteEncodedArray(longOctalString);
        byte[] hexaToDecimal = getHexaToByteEncodedArray("1FFAbc");
        byte[] b32ToDecimal = getBase32ToByteEncodedArray("178vbjdi210df");

         */
``