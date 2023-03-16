import React from "react";

import { Input } from "@/components/ui/input";

import {
  FilterOptionsHeader,
  FilterOptionsBody,
  FilterOptionsTitle,
  FilterOptionsBodyItem,
  FilterOptionsWrapper
} from "./styles";

interface IFilterCardProps {
  categorys: Object,
}

export const FilterCard: React.FC<IFilterCardProps> = ({ categorys }) => {
  return (
    <>
      <FilterOptionsWrapper>
        <FilterOptionsHeader>
          <FilterOptionsTitle>Porte</FilterOptionsTitle>
        </FilterOptionsHeader>
        <FilterOptionsBody>
          <FilterOptionsBodyItem>
            <Input type="checkbox" id="select" /> Pequeno
          </FilterOptionsBodyItem>
          <FilterOptionsBodyItem>
            <Input type="checkbox" id="select" /> Médio
          </FilterOptionsBodyItem>
          <FilterOptionsBodyItem>
            <Input type="checkbox" id="select" /> Grande
          </FilterOptionsBodyItem>
        </FilterOptionsBody>
      </FilterOptionsWrapper>
    </>
  );
};
