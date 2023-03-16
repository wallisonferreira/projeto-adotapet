import { NextPage } from 'next/types';

import { Layout }  from '@/layout';
import {Adoption} from '@/features/adoption_pet'

const AdoptionPage: NextPage = () => {
  return (
    <Layout>
        <Adoption/> 
    </Layout>
  );
}

export default AdoptionPage;
