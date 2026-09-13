#include <stdio.h>
#include <string.h>

// XOR operation
void xorOperation(char *a, char *b, char *result) {
    int len = strlen(b);

    for (int i = 1; i < len; i++) {
        result[i - 1] = (a[i] == b[i]) ? '0' : '1';
    }
    result[len - 1] = '\0';
}

// Division process
void mod2div(char *dividend, char *divisor, char *remainder) {
    int pick = strlen(divisor);
    int dividendLen = strlen(dividend);

    char tmp[100];
    strncpy(tmp, dividend, pick);
    tmp[pick] = '\0';

    while (pick < dividendLen) {
        char xorResult[100];

        if (tmp[0] == '1') {
            xorOperation(divisor, tmp, xorResult);
        } else {
            char zeros[100];
            for (int i = 0; i < strlen(divisor); i++) {
                zeros[i] = '0';
            }
            zeros[strlen(divisor)] = '\0';

            xorOperation(zeros, tmp, xorResult);
        }

        int len = strlen(xorResult);
        xorResult[len] = dividend[pick];
        xorResult[len + 1] = '\0';

        strcpy(tmp, xorResult);
        pick++;
    }

    if (tmp[0] == '1') {
        xorOperation(divisor, tmp, remainder);
    } else {
        char zeros[100];
        for (int i = 0; i < strlen(divisor); i++) {
            zeros[i] = '0';
        }
        zeros[strlen(divisor)] = '\0';

        xorOperation(zeros, tmp, remainder);
    }
}

// Encode data
void encodeData(char *data, char *key, char *encodedData) {
    int keyLen = strlen(key);

    char appendedData[200];

    strcpy(appendedData, data);

    for (int i = 0; i < keyLen - 1; i++) {
        strcat(appendedData, "0");
    }

    char remainder[100];
    mod2div(appendedData, key, remainder);

    strcpy(encodedData, data);
    strcat(encodedData, remainder);
}

int main() {
    char data[100], key[100];
    char encodedData[200];

    printf("Enter data (binary): ");
    scanf("%s", data);

    printf("Enter generator polynomial (binary): ");
    scanf("%s", key);

    encodeData(data, key, encodedData);

    printf("Encoded Data (with CRC): %s\n", encodedData);

    // Receiver side
    char remainder[100];
    mod2div(encodedData, key, remainder);

    int error = 0;

    for (int i = 0; i < strlen(remainder); i++) {
        if (remainder[i] != '0') {
            error = 1;
            break;
        }
    }

    if (error == 0) {
        printf("No Error Detected\n");
    } else {
        printf("Error Detected\n");
    }

    return 0;
}