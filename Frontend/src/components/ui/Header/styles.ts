import { styled } from "@stitches/react";

export const HeaderContainer = styled("header", {
  display: "flex",
  flexDirection: "row",
  alignItems: "center",
  justifyContent: "space-between",
  backgroundColor: "$background",
  height: "73px",
  minHeight: "auto",
  boxShadow: "$sm",
  padding: "0 6em 0 6em",
  gap: "1.5em",
  position: 'sticky',
  top: 0,
});

export const HeaderImage = styled("img", {
  width: "auto",
  maxWidth: "190px",
});

export const HeaderLogo = styled("div", {
  display: "flex",
  alignItems: "center",
  justifyContent: "center",
  width: "100%",
  gap: "1em",
});

export const HeaderLinks = styled("nav", {
  display: "flex",
  alignItems: "center",
  gap: "1em",
});

export const HeaderLinkGroup = styled("ul", {
  display: 'flex',
  width: '100%',
  color: "$brand",
  cursor: 'pointer',
});

export const HeaderLink = styled("li", {
  display: 'flex',
  width: '100%',
  gap: '0.3em',
  color: "$brand",
});
