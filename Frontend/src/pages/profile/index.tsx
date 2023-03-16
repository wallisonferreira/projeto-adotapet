import { ProfilePet } from '@/features/profile_pet';

import { Layout } from '@/layout';

import React from 'react';

const ProfilePage: React.FC = () => {
  return (
    <Layout>
      <ProfilePet/>
    </Layout>
  );
}

export default ProfilePage;