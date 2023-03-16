import { styled } from "@stitches/react";

export const CategorySection = styled("section", {
  display: "flex",
  flexDirection: "column",
  gap: "3em",
});

export const CategoryLabel = styled("h1", {
  fontSize: "1.3em",
  fontWeight: "600",
  color: "#000000",
});

export const CategoryList = styled("div", {
  display: "flex",
  alignItems: "center",
  width: "100%",
  gap: '1em'
});

export const CategoryItem = styled("div", {
  display: "flex",
  flexDirection: "row",
  alignItems: "center",
  paddingLeft: "0.5em",
  borderRadius: '0.5em',
  backgroundColor: "#ffffff",
  border: '0.5px solid #e0e0e0',
  fontWeight: '500',
  fontSize: '1em',
  width: "13em",
  height: "4.5em",
  flexWrap: "wrap",
  cursor: 'pointer',
  gap: "1em",

  '&:hover': {
    border: '0.5px solid #cccccc',
  }
});

export const CategoryIcon = styled("div", {
  display: "flex",
  alignItems: "center",
  justifyContent: "center",
  backgroundColor: '#fef1f1',
  height: '80%',
  width: '30%',
  borderRadius: '0.5em'
})

export const CategoryTitle = styled("p", {
    fontSize: '0.9em',
  });
