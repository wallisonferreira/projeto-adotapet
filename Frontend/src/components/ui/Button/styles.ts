import { styled } from "@stitches/react";

export const StyledButton = styled("button", {
  display: "flex",
  alignItems: "center",
  justifyContent: "center",
  cursor: "pointer",
  padding: "0.80em",

  variants: {
    size: {
      sm: {
        width: "auto",
        minWidth: "120px",
        fontSize: "0.78rem",
        lineHeight: "1.25rem",
        fontWeight: "600",
      },
    },
    type: {
      primary: {
        backgroundColor: "$brand",
        color: "#FFFFFF",

        "&&:hover": {
          backgroundColor: "$brandHover",
        },

      },
      outline: {
        backgroundColor: "transparent",
        border: "1px solid $brand",
        color: "$brand",

        "&&:hover": {
          color: "#FFFFFF",
          backgroundColor: "$brandHover",
        },

      },
    },
    radius: {
      sm: {
        borderRadius: "$sm",
      },
      md: {
        borderRadius: "$md",
      },
      lg: {
        borderRadius: "$lg",
      },
    },
  },
});
