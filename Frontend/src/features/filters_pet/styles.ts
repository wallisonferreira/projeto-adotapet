import { styled } from "@stitches/react";

export const FiltersContainer = styled("section", {
    display: 'grid',
    gridTemplateColumns: 'auto 1fr',
    marginTop: '3em',
    width: '100%',
    gridGap: '1em'
})

export const FilterOptions = styled('div', {
    display: 'flex',
    gap: '1em',
    width: '18em',
    flexDirection: 'column',
})

export const FilterContent = styled('div', {
    display: 'flex',
})