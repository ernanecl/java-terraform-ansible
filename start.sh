#cd itau-tdd-lab
#docker login --username ernanecl foo --password-stdin ~/my_password.txt
docker build -t ernanecl/app-java-validacao-cnpj -f Dockerfile .
docker run -d -p 8081:8081 --name app-java-validacao-cnpj ernanecl/app-java-validacao-cnpj
docker exec -it app-java-validacao-cnpj npm run test
docker stop app-java-validacao-cnpj
docker tag ernanecl/app-java-validacao-cnpj https://hub.docker.com/repository/docker/ernanecl/app-java-validacao-cnpj
docker push ernanecl/app-java-validacao-cnpj
docker rm app-java-validacao-cnpj

cd ../terraform
~/terraform/terraform init
~/terraform/terraform validate
~/terraform/terraform apply -auto-approve

echo "Aguardando criação de maquinas ..."
sleep 10 # 10 segundos

# echo $"[ec2-nodejs]" > ../ansible/hosts # cria arquivo ???
echo "$(~/terraform/terraform output | awk '{print $3;exit}')" >> ../ansible/hosts # captura output faz split de espaco e replace de ",

echo "Aguardando criação de maquinas ..."
sleep 10 # 20 segundos

cd ../ansible
ansible-playbook -i hosts provisionar.yml -u ubuntu --private-key ~/.ssh/id_rsa

cd ../terraform

open "http://$(~/terraform/terraform output | awk '{print $3;exit}' | sed -e "s/\"//g")"

# *** verifica se aplicação está de pé
# sudo lsof -iTCP -sTCP:LISTEN -P | grep :8081


./mvnw spring-boot:run
