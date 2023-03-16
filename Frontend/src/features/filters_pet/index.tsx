import React from "react";

import { FilterCard } from "@/components/cards/filter";

import { FiltersContainer, FilterOptions, FilterContent } from "./styles";

const PortCategory = ['Pequeno', 'Médio', 'Grande'];
const SexCategory = ['Macho', 'Fêmea'];

export const Filters: React.FC = () => {
  return (
    <FiltersContainer>
      <FilterOptions>
        <FilterCard categorys={PortCategory}/>
        <FilterCard categorys={SexCategory}/>
      </FilterOptions>
      <FilterContent>
        Conteudo
        </FilterContent>
    </FiltersContainer>
  );
};

export default Filters;
