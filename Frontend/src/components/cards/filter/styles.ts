import { styled } from "@stitches/react";

export const FilterOptionsHeader = styled("div", {
  display: "flex",
  alignItems: "center",
  width: "100%",
  backgroundColor: "$brand",
  color: "white",
  fontSize: "0.95em",
  borderTopLeftRadius: "0.3em",
  borderTopRightRadius: "0.3em",
  height: "2.8em",
});

export const FilterOptionsTitle = styled("div", {
  display: "flex",
  paddingLeft: "1em",
  fontSize: "1em",
  fontWeight: "500",
});

export const FilterOptionsBody = styled("div", {
  display: "flex",
  flexDirection: "column",
  backgroundColor: "#FFFFFF",
  padding: "0.9em",
});

export const FilterOptionsBodyItem = styled("div", {
  display: "flex",
  alignItems: "center",
  gap: "0.5em",
});


export const FilterOptionsWrapper = styled("div", {
  display: 'flex',
  flexDirection: 'column',
})