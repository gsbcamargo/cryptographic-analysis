# AV – Exercício: Análise de Desempenho Criptográfico

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


**Relátorio**: Todas 1º execução foi realizada com a chave sendo criada no file system, às execuções subsequentes foram executadas com às chaves já criadas. Foi possível observar um aumento gradativo do tempo de execução da criptográfia proporcional ao tamanho da chave, o fator que mais causou impacto no tempo decorrido foi a criação da mesma, nas execuções onde a mesma já estava criada não ouve uma diferença tão signigicativa.

Data must not be longer than 53 bytes