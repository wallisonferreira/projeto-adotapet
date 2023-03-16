import React from "react";

import { Input } from '@/components/ui/input'
import { Button } from '@/components/ui/button'

import {
  HeaderContainer,
  HeaderLogo,
  HeaderLinks,
  HeaderImage,
  HeaderLinkGroup,
  HeaderLink,
} from "./styles";
import { DialogAuthComponent } from "../Dialog/auth";

export const Header: React.FC = () => {
  return (
    <HeaderContainer>
      <HeaderLogo>
        <HeaderImage src="/images/logo.svg" alt="Logo" />
        <Input
          variant="default"
          size="full"
          placeholder="Digite o que você procura..."
        />
      </HeaderLogo>
      <HeaderLinks>
        <HeaderLinkGroup>
          <HeaderLink>
            Perdidos
          </HeaderLink>
        </HeaderLinkGroup>
        <DialogAuthComponent>
          <Button label="Começar agora" size="sm" type="primary" radius="md" />
        </DialogAuthComponent>
      </HeaderLinks>
    </HeaderContainer>
  );
};

export default Header;
