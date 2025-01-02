

import SearchLoja from '@/components/SearchLoja';
import Menu from '@/components/Menu';
import ItensProjetos from './ItensProjetos';
import ProjetoApi from './ProjetoApi';


function Projetos() {

    return (
        <div className="flex overflow-hidden">
            <Menu usuarioID={''} />
            <div className="flex flex-col w-full overflow-hidden">
                <SearchLoja />
                <div className="flex h-[92.2vh] bg-[#F5F5F5] justify-center items-center">
                    <div className="flex w-full h-full">
                        <div className="flex flex-col w-full h-full bg-[#EEEEEE] mt-[2.2%] mb-[10%] overflow-hidden">
                            <ItensProjetos/>
                            <div className="flex flex-col h-full overflow-y-auto ml-48">
                            <ProjetoApi/>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default Projetos;
