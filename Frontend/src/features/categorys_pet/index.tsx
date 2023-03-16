import React from "react";

import {
  CategorySection,
  CategoryList,
  CategoryItem,
  CategoryIcon,
} from "./styles";

import { FaCat, FaDog } from "react-icons/fa";
import { MdPets } from 'react-icons/md'

export const Categorys: React.FC = () => {
  return (
    <CategorySection>
      <CategoryList>
      <CategoryItem>
          <CategoryIcon>
            <MdPets size={25} color="#EC5161" />
          </CategoryIcon>
          Mostrar todos
        </CategoryItem>
        <CategoryItem>
          <CategoryIcon>
            <FaDog size={25} color="#EC5161" />
          </CategoryIcon>
          Cachorross
        </CategoryItem>
        <CategoryItem>
          <CategoryIcon>
            <FaCat size={25} color="#EC5161" />
          </CategoryIcon>
          Gatos
        </CategoryItem>
      </CategoryList>
    </CategorySection>
  );
};
