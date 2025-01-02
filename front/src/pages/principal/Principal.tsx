import { Link } from "react-router-dom";
import { FaSolarPanel, FaLeaf, FaLightbulb, FaHandsHelping } from "react-icons/fa";
import { useEffect } from "react";
import ScrollReveal from "scrollreveal";

const Principal = () => {
    useEffect(() => {
        ScrollReveal().reveal(".reveal", {
            delay: 200,
            distance: "50px",
            duration: 1000,
            easing: "ease-in-out",
            origin: "bottom",
        });
    }, []);

    return (
        <div className="font-sans h-screen flex flex-col">
            {/* Header */}
            <header className="bg-gradient-to-r from-blue-500 to-blue-800 text-white py-8 text-center fixed top-0 left-0 right-0 z-10 shadow-md">
                <div className="container mx-auto flex justify-between items-center px-8">
                    <div>
                        <h1 className="text-4xl font-bold">Sunbridge Energy</h1>
                        <p className="text-lg mt-2">Iluminando o futuro com energia limpa.</p>
                    </div>
                    <Link to="/login">
                        <div className="bg-blue-600 text-white px-6 py-2 rounded-full shadow hover:bg-blue-700 transition">
                            Login
                        </div>
                    </Link>
                </div>
            </header>

            {/* Main Content */}
            <main className="overflow-auto mt-[120px] flex-1 bg-gray-50">
                {/* Quem Somos */}
                <section className="py-16 reveal">
                    <div className="container mx-auto px-6 text-center">
                        <h2 className="text-3xl font-bold text-gray-800 mb-4">Quem somos?</h2>
                        <p className="text-lg text-gray-600 leading-relaxed">
                            A <strong>Sunbridge Energy</strong> é dedicada à transformação da matriz energética, oferecendo
                            soluções completas em energia solar fotovoltaica para residências, empresas e indústrias. Nossa missão
                            é tornar a energia limpa e sustentável acessível para todos, reduzindo custos e promovendo um futuro
                            mais verde.
                        </p>
                    </div>
                </section>

                {/* Por que escolher */}
                <section className="bg-white py-16 reveal">
                    <div className="container mx-auto px-6">
                        <h2 className="text-3xl font-bold text-center text-gray-800 mb-6">Por que escolher a Sunbridge Energy?</h2>
                        <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-4 gap-6">
                            <div className="text-center">
                                <FaSolarPanel className="text-blue-500 text-6xl mx-auto mb-4" />
                                <h3 className="text-lg font-semibold text-gray-800">Tecnologia de ponta</h3>
                                <p className="text-gray-600 mt-2">
                                    Equipamentos e painéis solares de alta eficiência no mercado.
                                </p>
                            </div>
                            <div className="text-center">
                                <FaHandsHelping className="text-blue-500 text-6xl mx-auto mb-4" />
                                <h3 className="text-lg font-semibold text-gray-800">Equipe especializada</h3>
                                <p className="text-gray-600 mt-2">
                                    Profissionais capacitados para suas necessidades específicas.
                                </p>
                            </div>
                            <div className="text-center">
                                <FaLightbulb className="text-blue-500 text-6xl mx-auto mb-4" />
                                <h3 className="text-lg font-semibold text-gray-800">Soluções financeiras</h3>
                                <p className="text-gray-600 mt-2">
                                    Opções de financiamento personalizadas para você.
                                </p>
                            </div>
                            <div className="text-center">
                                <FaLeaf className="text-blue-500 text-6xl mx-auto mb-4" />
                                <h3 className="text-lg font-semibold text-gray-800">Sustentabilidade</h3>
                                <p className="text-gray-600 mt-2">
                                    Contribuímos para a preservação do meio ambiente.
                                </p>
                            </div>
                        </div>
                    </div>
                </section>

                {/* Serviços */}
                <section className="bg-gray-100 py-16 reveal">
                    <div className="container mx-auto px-6 text-center">
                        <h2 className="text-3xl font-bold text-gray-800 mb-6">Nossos serviços incluem</h2>
                        <ul className="text-left inline-block text-lg text-gray-600 leading-relaxed">
                            <li className="mb-3">✓ Consultoria e planejamento do sistema solar.</li>
                            <li className="mb-3">✓ Instalação de painéis solares residenciais e industriais.</li>
                            <li className="mb-3">✓ Monitoramento contínuo para garantir eficiência.</li>
                            <li className="mb-3">✓ Assistência no processo de regulamentação.</li>
                        </ul>
                    </div>
                </section>

                {/* Por que investir */}
                <section className="py-16 reveal">
                    <div className="container mx-auto px-6 text-center">
                        <h2 className="text-3xl font-bold text-gray-800 mb-6">Por que investir em energia solar?</h2>
                        <ul className="text-lg text-gray-600 space-y-4">
                            <li>Redução de até 95% na sua conta de energia.</li>
                            <li>Valorização do imóvel com tecnologia limpa.</li>
                            <li>Independência energética e proteção contra aumentos de tarifas.</li>
                        </ul>
                    </div>
                </section>
            </main>

            {/* Footer */}
            <footer className="bg-gradient-to-r from-blue-500 to-blue-800 text-white py-8">
                <div className="container mx-auto text-center">
                    <p className="text-lg">
                        Invista no futuro hoje mesmo. Faça parte da revolução solar com a <strong>Sunbridge Energy</strong>.
                    </p>
                </div>
            </footer>

            {/* Fixed Call-to-Action */}
            <a
                href="tel:+551199999999"
                className="fixed bottom-5 right-5 bg-blue-500 text-white px-6 py-3 rounded-full shadow-lg hover:bg-blue-700 transition"
            >
                Chame-nos agora!
            </a>
        </div>
    );
};

export default Principal;
