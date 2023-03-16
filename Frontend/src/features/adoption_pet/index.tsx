import React from "react";
import { 
    Container, 
    ContainerBox, 
    ContainerTitle, 
    ContainerContent, 
    ListContainerAdoptions, 
    ListContainerBox, 
    ContainerImg, 
    ContainerInformations, 
    ContainerName, 
    CategoryIcon, 
    ContainerProcess, 
    ContainerCode, 
    ContainerStatus, 
    CategoryStatus, 
    ContainerDate,
    DateValue, 
    ContainerHelp } from "./styles";
    
import maggie from "public/images/maggie.png";
import max from "public/images/max.png";
import bob from "public/images/bob.png";
import { SiGooglemaps } from "react-icons/si";
import { BsFillPersonFill } from "react-icons/bs";
import Image from 'next/image'



export const Adoption: React.FC = () => {
    return (
        <>
            <Container>
                <ContainerBox>
                    <ContainerTitle>Filtrar por: </ContainerTitle>
                    <ContainerContent>Minhas adoções</ContainerContent>
                </ContainerBox>
            </Container>
            <ListContainerAdoptions>
                <ListContainerBox>
                    <ContainerImg>
                        <Image src={maggie} alt="Foto 1" width={150} height={150} />
                    </ContainerImg>
                    <ContainerInformations>
                        <ContainerName>Maggie</ContainerName>
                        <CategoryIcon>
                            <SiGooglemaps size={14} color="#EC5161" />
                            Está em FLORIANOPOLIS, SC
                        </CategoryIcon>
                        <CategoryIcon>
                            <BsFillPersonFill size={14} color="#EC5161" />
                            Publicado por Patinha Carente em 01/01/2023
                        </CategoryIcon>
                    </ContainerInformations>
                    <ContainerProcess>
                        <ContainerName>PROCESSO</ContainerName>
                        <ContainerCode>#12346678</ContainerCode>
                    </ContainerProcess>
                    <ContainerStatus>
                        <ContainerName>STATUS</ContainerName>
                        <CategoryStatus>Aprovado</CategoryStatus>
                    </ContainerStatus>
                    <ContainerDate>
                        <ContainerName>DATA</ContainerName>
                    </ContainerDate>
                    <ContainerHelp>
                        <button>Precisa de Ajuda?</button>
                    </ContainerHelp>
                </ListContainerBox>
                <ListContainerBox>
                    <ContainerImg>
                        <Image src={max} alt="Foto 2" width={150} height={150} />
                    </ContainerImg>
                    <ContainerInformations>
                        <ContainerName>Max</ContainerName>
                        <CategoryIcon>
                            <SiGooglemaps size={25} color="#EC5161" />
                            Está em RIO BRANCO, AC
                        </CategoryIcon>
                        <CategoryIcon>
                            <BsFillPersonFill size={25} color="#EC5161" />
                            Publicado por Patinha Carente em 01/01/2023
                        </CategoryIcon>
                    </ContainerInformations>
                    <ContainerProcess>
                        <ContainerName>PROCESSO</ContainerName>
                        {/* <ContainerCode>#12346678</ContainerCode> */}
                    </ContainerProcess>
                    <ContainerStatus>
                        <ContainerName>STATUS</ContainerName>
                        {/* <CategoryStatus>Aprovado</CategoryStatus> */}
                    </ContainerStatus>
                    <ContainerDate>
                        <ContainerName>DATA</ContainerName>
                    </ContainerDate>
                    <ContainerHelp>
                        <button>Precisa de Ajuda?</button>
                    </ContainerHelp>
                </ListContainerBox>
                <ListContainerBox>
                    <ContainerImg>
                        <Image src={bob} alt="Foto 3" width={150} height={150} />
                    </ContainerImg>
                    <ContainerInformations>
                        <ContainerName>Bob</ContainerName>
                        <CategoryIcon>
                            <SiGooglemaps size={25} color="#EC5161" />
                            Está em PORTO VELHO, RO
                        </CategoryIcon>
                        <CategoryIcon>
                            <BsFillPersonFill size={25} color="#EC5161" />
                            Publicado por Patinha Carente em 01/01/2023
                        </CategoryIcon>
                    </ContainerInformations>
                    <ContainerProcess>
                        <ContainerName>PROCESSO</ContainerName>
                        <ContainerCode>#12346678</ContainerCode>
                    </ContainerProcess>
                    <ContainerStatus>
                        <ContainerName>STATUS</ContainerName>
                        <CategoryStatus>Aprovado</CategoryStatus>
                    </ContainerStatus>
                    <ContainerDate>
                        <ContainerName>DATA</ContainerName>
                        <DateValue>24/12/2023</DateValue>
                    </ContainerDate>
                    <ContainerHelp>
                        <button>Precisa de Ajuda?</button>
                    </ContainerHelp>
                </ListContainerBox>
            </ListContainerAdoptions>

        </>
    );
};
