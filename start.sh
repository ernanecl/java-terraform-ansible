# login no Docker no terminal
# docker login --username ernanecl foo --password-stdin ~/my_password.txt

# cria o arquivo Dockerfile dentro da aplicação
docker build -t ernanecl/app-java-validacao-cnpj -f Dockerfile .

# executa a aplicação, entrando pela porta 80 e acessando a porta 8081 da aplicação, nome do container e rota da aplicação
docker run -d -p 8081:8081 --name app-java-validacao-cnpj ernanecl/app-java-validacao-cnpj

# parando a aplicação Java
docker stop app-java-validacao-cnpj

# criando uma marcação do container Docker local e com o Docker Hub
docker tag ernanecl/app-java-validacao-cnpj https://hub.docker.com/repository/docker/ernanecl/app-java-validacao-cnpj

# atualizando Docker Hub
docker push ernanecl/app-java-validacao-cnpj

# excluindo container  local
docker rm app-java-validacao-cnpj

# acessando diretório do Terraform
cd ../terraform

# iniciando o Terraform
~/terraform/terraform init

# validando código do Terraform
~/terraform/terraform validate

# executando automação do Terraform
~/terraform/terraform apply -auto-approve

#echo "Aguardando criação de maquinas ..."
#sleep 10 # 10 segundos

# echo $"[ec2-nodejs]" > ../ansible/hosts # cria arquivo ???
#echo "$(~/terraform/terraform output | awk '{print $3;exit}')" >> ../ansible/hosts # captura output faz split de espaco e replace de ",

#echo "Aguardando criação de maquinas ..."
#sleep 10 # 20 segundos

#cd ../ansible
#ansible-playbook -i hosts provisionar.yml -u ubuntu --private-key ~/.ssh/id_rsa

#cd ../terraform

#open "http://$(~/terraform/terraform output | awk '{print $3;exit}' | sed -e "s/\"//g")"

# executa a aplicação
./mvnw spring-boot:run

# *** verifica se aplicação está de pé
sudo lsof -iTCP -sTCP:LISTEN -P | grep :8081


