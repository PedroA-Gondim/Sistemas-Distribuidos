# Sistemas-Distribuidos
Projeto final desenvolvido para a disciplina de Sistemas Distribuídos

- Requisitos a serem atendidos:
  - [ ] Utilizar, obrigatoriamente, gRPC para comunicação entre clientes e servidores.  
  - [ ] Utilizar, obrigatoriamente, MQTT para atualização de estado entre servidores.  
  - [ ] Implementar os casos de uso usando tabelas hash locais aos servidores, em memória (hash tables, dicionários, mapas, etc).  
  - [ ] Implementar servidor com interface de linha de comando para execução.  
  - [ ] Certificar-se de que todas as APIs possam retornar erros/exceções e que estas são tratadas, explicando sua decisão de tratamento dos erros.  
  - [ ] Documentar o esquema de dados usados nas tabelas.  
  - [ ] Suportar a execução de múltiplos clientes e servidores.  
  - [ ] Implementar a propagação de informação entre servidores usando necessariamente pub-sub, já que a comunicação é de 1 para muitos.  
  - [ ] Utilizar o broker pub-sub mosquitto com a configuração padrão e aceitando conexões na interface local (localhost ou 127.0.0.1), porta TCP 1883.  
  - [ ] Gravar um vídeo de no máximo 5 minutos demonstrando que os requisitos foram atendidos.
 
  # Instalação:
  Para a utilização do cliente de teste foi utilizada uma abordagem de submodule, assim ao momento de clonagem utilize os seguintes comandos:
  Situação	| Comando
  ----------|----------
  Clone inicial |	`git clone --recursive https://github.com/PedroA-Gondim/Sistemas-Distribuidos.git`
  Clone sem submodule |	`git submodule update --init`
  Atualizar submodule	| `git submodule update --remote`

