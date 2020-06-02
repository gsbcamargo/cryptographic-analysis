# cryptographic-analysis
Script used to count the whole duration of the encryption and decryption of a text, including the time used to generate the keys.

Desenvolva um programa (java) que utiliza a criptografia de chave pública e simétrica conforme requisitos abaixo:

1. O programa deve cifrar o texto: “RSA é um algoritmo que deve o seu nome a três professores do MIT: Ronald Rivest, Adi Shamir e Leonard Adleman”.

2. O programa deve cifrar o texto utilizando as seguintes técnicas:

a. Utilizando o algoritmo RSA com chave pública de 1024 bits.

b. Utilizando o algoritmo RSA com chave privada de 1024 bits.

c. Utilizando o algoritmo RSA com chave pública de 2048 bits.

d. Utilizando o algoritmo RSA com chave privada de 2048 bits.

e. Utilizando o algoritmo RSA com chave pública de 4096 bits.

f. Utilizando o algoritmo RSA com chave privada de 4096 bits.

g. Utilizando o algoritmo RSA com chave pública de 8192 bits.

h. Utilizando o algoritmo RSA com chave privada de 8192 bits.

i. Utilizando o algoritmo AES com chave de 16 bytes.

3. O programa deve calcular o tempo de execução do experimento, incluindo a geração de chaves.

4. Cada uma das técnicas deve ser executada pelo menos três vezes. É recomendado que o processo não seja automatizado, para que o resultado não utilize cache.

5. Finalmente, cifre o texto utilizando o algoritmo RSA com chave de 512 bits.

Desenvolva um relatório descrevendo o experimento executado. O relatório deve descrever o resultado das execuções, realizando uma análise do tempo de resposta das diversas técnicas. Adicionalmente, deve ser entregue o código fonte.

## Resultado da análise criptográfica
##### OBS.: tempo de execução em milisegundos.

|                        | 1.ª Execuçao | 2.ª Execução | 3.ª Execução |
|------------------------|:------------:|:------------:|:------------:|
| RSA 1024 chave pública |     2264     |     1666     |     1552     |
| RSA 1024 chave privada |     2881     |     1684     |     1918     |
| RSA 2048 chave pública |     2372     |     2033     |     2172     |
| RSA 2048 chave privada |     2373     |     2100     |     1952     |
| RSA 4096 chave pública |     4231     |     2074     |     2672     |
| RSA 4096 chave privada |     4162     |     1962     |     2276     |
| RSA 8192 chave pública |     72722    |     2256     |     2250     |
| RSA 8192 chave privada |     28880    |     2510     |     2472     |
| AES 16 bytes           |     1580     |     1739     |     1747     |
| RSA 512 chave pública  |   Exception  |   Exception  |   Exception  |
| RSA 512 chave privada  |   Exception  |   Exception  |   Exception  |


**Relátorio**: 
Todas as primeiras execuções foram realizadas com a chave sendo 
gerada no diretamente pelo script. As execuções subsequentes foram realizadas 
com chaves anteriormente geradas. 
Foi possível observar um aumento gradativo no tempo de 
execução criptográfica proporcional ao tamanho da chave, 
apesar da discrepância de tempo entre 
as chaves de até 4086 bits e a de 8192 bits. 
O fator que mais causou impacto no tempo total de execução 
foi a criação das chaves. Nas execuções cujas chaves já haviam sido criadas, 
o tempo de execução foi, no geral, uniforme.

A única a ter algum problema de execução foi a de tamanho de 512 bits, 
cuja efetivação foi interrompida por uma exceção (Data must not be longer than 53 bytes), 
já que o dado de entrada não pode ser superior a 53 bytes (carecteres).
