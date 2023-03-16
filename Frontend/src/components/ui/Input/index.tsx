import React from "react";

import { StyledInput } from "./styles";

type StyleInputProps = React.ComponentProps<typeof StyledInput>;

export type InputProps = Omit<StyleInputProps, "css"> & {
    variant?: "default" | "iconed";
    icon?: string;
};

export const Input: React.FC<InputProps> = ({ ...rest }) => {
    return <StyledInput {...rest} />;
};