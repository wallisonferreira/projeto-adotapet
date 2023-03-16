import React from "react";

import { StyledButton } from "./styles";

type StyleButtonProps = React.ComponentProps<typeof StyledButton>;

export type ButtonProps = Omit<StyleButtonProps, "css"> & {
  label: string;
};

export const Button: React.FC<ButtonProps> = ({ label, ...rest }) => {
  return <StyledButton {...rest}>{label}</StyledButton>;
};
