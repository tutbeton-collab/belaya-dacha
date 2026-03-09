import Image from 'next/image';

const advantages = [
  {
    icon: '🌿',
    title: 'Натуральный вкус',
    description: 'Наши овощи обладают тем самым вкусом, который многие помнят из детства — настоящий, насыщенный, без искусственных добавок.',
    image: '/images/vegetables/tomatoes.jpg',
  },
  {
    icon: '🌱',
    title: 'Выращено на живой земле',
    description: 'Мы заботимся о здоровье почвы, используем натуральные удобрения и соблюдаем принципы органического земледелия.',
    image: '/images/vegetables/greens.jpg',
  },
  {
    icon: '👨‍👩‍👧‍👦',
    title: 'Семейная ферма',
    description: 'Мы — небольшая семья, которая лично занимается каждым кустом. Для нас это не бизнес, а образ жизни и дело чести.',
    image: '/images/gallery-5.jpg',
  },
  {
    icon: '🚫',
    title: 'Без промышленного производства',
    description: 'Никаких конвейеров и массового производства. Только ручной труд, внимание к деталям и индивидуальный подход.',
    image: '/images/gallery-4.jpg',
  },
  {
    icon: '📞',
    title: 'Прямой контакт с фермером',
    description: 'Вы общаетесь напрямую с теми, кто выращивал ваши овощи. Всегда готовы ответить на вопросы и дать рекомендации.',
    image: '/images/gallery-6.jpg',
  },
];

export default function Advantages() {
  return (
    <section id="advantages" className="section bg-white">
      <div className="container mx-auto px-4">
        <h2 className="section-title">Почему выбирают нас</h2>
        <p className="section-subtitle">
          Преимущества нашей небольшой семейной фермы
        </p>

        <div className="grid md:grid-cols-2 lg:grid-cols-3 gap-8 max-w-6xl mx-auto">
          {advantages.map((adv, index) => (
            <div
              key={adv.title}
              className="group text-center p-6 rounded-2xl bg-farm-cream hover:bg-farm-green/10 transition-colors duration-300 hover-lift"
              style={{ animationDelay: `${index * 0.1}s` }}
            >
              <div className="relative h-40 w-full mb-4 rounded-xl overflow-hidden shadow-md">
                <Image
                  src={adv.image}
                  alt={adv.title}
                  fill
                  className="object-cover group-hover:scale-110 transition-transform duration-300"
                />
              </div>
              <div className="text-4xl mb-3">{adv.icon}</div>
              <h3 className="text-xl font-bold text-farm-green mb-3">{adv.title}</h3>
              <p className="text-farm-brown leading-relaxed">{adv.description}</p>
            </div>
          ))}
        </div>
      </div>
    </section>
  );
}
