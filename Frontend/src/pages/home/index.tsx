import { NextPage } from 'next/types';

import { Layout }  from '@/layout';

import { Categorys } from '@/features/categorys_pet';
import { Filters } from  '@/features/filters_pet';

const HomePage: NextPage = () => {
  return (
    <Layout>
      <Categorys />
      <Filters />
    </Layout>
  );
}

export default HomePage;
