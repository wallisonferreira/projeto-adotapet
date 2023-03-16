import { styled } from "@stitches/react";

export const StyledInput = styled("input", {
  display: "flex",
  height: "auto",
  minHeight: "43px",
  paddingLeft: "1em",
  borderRadius: "$sm",
  backgroundColor: "#ECE8F0",
  border: "none",
  outline: "none",
  color: "gray",

  variants: {
    size: {
      full: {
        width: "100%",
      },
    },
  },
});
