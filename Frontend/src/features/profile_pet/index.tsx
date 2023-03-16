import React from 'react';
import { Container, ContainerLeft, ContainerRigth, LeftOne, Title, Text, ContainerRigthOne, Title2, Form } from './styles';

export const ProfilePet: React.FC = () => {
  return (
    <Container>
      <ContainerLeft>
        <LeftOne>Meu cadastro</LeftOne>
        <LeftOne>Segurança e privacidade</LeftOne>
        <LeftOne>Meu nível</LeftOne>
      </ContainerLeft>
      <ContainerRigth>
        <Title>Meu cadastro</Title>
        <Text>Configure o seu cadastro.</Text>
        <ContainerRigthOne>
          <Title2>Dados da conta</Title2>
          <Form>
            <Divi>
              <label htmlFor="name">Nome completo</label>
              <Entrada type="text" name="name" id="name" />
            </Divi>
            <div>
              <label htmlFor="name">CPF</label>
              <input type="text" name="cpf" id="cpf" />
            </div>
            <div>
              <label htmlFor="name">Gênero</label>
              <input type="checkbox" name="genero" id="genero" />
            </div>
            <div>
              <label htmlFor="name">Email</label>
              <input type="email" name="email" id="email" />
            </div>
            <div>
              <label htmlFor="name">Telefone</label>
              <input type="text" name="telefone" id="telefone" />
            </div>
          </Form>

        </ContainerRigthOne>
        
      </ContainerRigth>
    </Container>
  );
}